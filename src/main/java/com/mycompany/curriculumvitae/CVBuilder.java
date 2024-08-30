/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.curriculumvitae;
import com.itextpdf.text.Chunk;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class CVBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("About Me: ");
        String aboutMe = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Website: ");
        String website = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Experience: ");
        String experience = scanner.nextLine();

        System.out.print("Education: ");
        String education = scanner.nextLine();

        System.out.print("Skills: ");
        String skills = scanner.nextLine();

        System.out.print("Certificates: ");
        String certificates = scanner.nextLine();
        
        System.out.print("Name CV: ");
        String nameCV = scanner.nextLine();

        // Membuat objek CV
        CV cv = new CV(name, aboutMe, email, website, phoneNumber, experience, education, skills, certificates);

        // Buat CV PDF
        createPDF(cv, nameCV);
    }
    public static void createPDF(CV cv, String nameCV) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nameCV+".pdf"));
            document.open();
            
             // Font Styles
            BaseFont baseFont = BaseFont.createFont("C:/./././main/java/com/././fonts/Montserrat-Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font nameFont = new Font(baseFont, 24, Font.BOLD);
            Font sectionTitleFont = new Font(baseFont, 14, Font.BOLD);
            Font textFont = new Font(baseFont, 12, Font.NORMAL);
            
            // Name and Title
            Paragraph name = new Paragraph(cv.getName(), nameFont);
            name.setAlignment(Element.ALIGN_CENTER);
            document.add(name);
            
            
            // Adding Space
            document.add(Chunk.NEWLINE);

            // Contact Information
            PdfPTable contactTable = new PdfPTable(2);
            contactTable.setWidthPercentage(100);
            
            PdfPCell aboutMeCell = new PdfPCell();
            aboutMeCell.setBorder(Rectangle.NO_BORDER);
            aboutMeCell.addElement(new Paragraph("ABOUT ME", sectionTitleFont));
            aboutMeCell.addElement(new Paragraph(cv.getAboutMe(), textFont));
            contactTable.addCell(aboutMeCell);
            
            PdfPCell contactCell = new PdfPCell();
            contactCell.setBorder(Rectangle.NO_BORDER);
            contactCell.addElement(new Paragraph("CONTACT", sectionTitleFont));
            contactCell.addElement(new Paragraph("Email: " + cv.getEmail(), textFont));
            contactCell.addElement(new Paragraph("Website: " + cv.getWebsite(), textFont));
            contactCell.addElement(new Paragraph("Phone Number: " + cv.getPhoneNumber(), textFont));
            contactTable.addCell(contactCell);

            document.add(contactTable);

            // Adding Space
            document.add(Chunk.NEWLINE);

            // Experiences Section
            document.add(new Paragraph("EXPERIENCES", sectionTitleFont));
            document.add(new Paragraph(cv.getExperience(), textFont));

            // Adding Space
            document.add(Chunk.NEWLINE);

            // Education Section
            document.add(new Paragraph("EDUCATION", sectionTitleFont));
            document.add(new Paragraph(cv.getEducation(), textFont));

            // Adding Space
            document.add(Chunk.NEWLINE);

            // Skills Section
            document.add(new Paragraph("SKILLS", sectionTitleFont));
            document.add(new Paragraph(cv.getSkills(), textFont));

            // Adding Space
            document.add(Chunk.NEWLINE);

            // Certificates Section
            document.add(new Paragraph("CERTIFICATES", sectionTitleFont));
            document.add(new Paragraph(cv.getCertificates(), textFont));
            
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(CVBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
        }
    }
}
