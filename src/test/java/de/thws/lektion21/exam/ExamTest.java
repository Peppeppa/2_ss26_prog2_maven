package de.thws.lektion21.exam;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExamTest {

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of("header.tex"));
        Files.deleteIfExists(Path.of("questions.csv"));
        Files.deleteIfExists(Path.of("test.tex"));
    }

    @Test
    void testTexFileIsCreated() throws IOException {
        Files.writeString(Path.of("header.tex"),
                "\\documentclass{article}\n" +
                        "\\begin{document}\n");

        Files.writeString(Path.of("questions.csv"),
                "Was besagt das Substitutionsprinzip?\n" +
                        "Was ist Polymorphie?\n");

        Exam exam = new Exam();

        exam.readQuestion();
        exam.toTest();

        File testFile = new File("test.tex");

        assertTrue(testFile.exists());
    }
}