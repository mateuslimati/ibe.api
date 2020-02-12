package com.gileadenm.ibe.api.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.gileadenm.ibe.api.models.Aluno;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	public static ByteArrayInputStream alunosPDFReport(List<Aluno> alunos) throws DocumentException {

		Document document = new Document(PageSize.A4, 36, 36, 90, 36);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		PdfWriter writer = PdfWriter.getInstance(document, out);

		// add header and footer
		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
		writer.setPageEvent(event);

		// write to document
		document.open();

		Paragraph para = new Paragraph("Corpo Discente", new Font(Font.FontFamily.TIMES_ROMAN, 14));
		para.setAlignment(Element.ALIGN_CENTER);

		document.add(para);

		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(3);

		table.setWidths(new int[] { 6, 14, 14});

		// Add PDF Table Header ->
		Stream.of("Matrícula", "Nome", "Email").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setPhrase(new Phrase(headerTitle, new Font(Font.FontFamily.TIMES_ROMAN, 12)));
			table.addCell(header);
		});

		alunos.sort((Aluno o1, Aluno o2) -> {
			if (o1.getMatricula() > o2.getMatricula())
				return 1;
			else
				return -1;
		});
		
		alunos.stream().forEach(aluno -> {

			PdfPCell matricula = new PdfPCell();
			matricula.setHorizontalAlignment(Element.ALIGN_CENTER);
			matricula.setPhrase(
					new Phrase(Long.toString(aluno.getMatricula()), new Font(Font.FontFamily.TIMES_ROMAN, 12)));
			table.addCell(matricula);

			PdfPCell nome = new PdfPCell();
			nome.setHorizontalAlignment(Element.ALIGN_CENTER);
			nome.setPhrase(new Phrase(aluno.getNome(), new Font(Font.FontFamily.TIMES_ROMAN, 12)));
			table.addCell(nome);

			PdfPCell email = new PdfPCell();
			email.setHorizontalAlignment(Element.ALIGN_CENTER);
			email.setPhrase(new Phrase(aluno.getEmail(), new Font(Font.FontFamily.TIMES_ROMAN, 12)));
			table.addCell(email);
		});

		document.add(table);

		document.close();

		return new ByteArrayInputStream(out.toByteArray());
	}
}