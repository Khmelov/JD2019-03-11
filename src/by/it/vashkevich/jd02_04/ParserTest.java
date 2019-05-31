package by.it.vashkevich.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ParserTest {
    private static Parser parser;

    @BeforeClass
    public static void createParser() {
        parser = new Parser();
    }

    @Test
    public void multipleOperations() throws Exception {
        Var var = parser.calc("{8,5}+7*6-4");
        String expected = "{46.0, 43.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createVar() throws Exception {
        parser.calc("X=5+2*8");
        Var var = Var.createVar("X");
        double expected = 21.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void scalarAddScalar() throws Exception {
        Var var = parser.calc("12+6");
        double expected = 18.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorAddScalar() throws Exception {
        Var var = parser.calc("{12,13}+6");
        String expected = "{18.0, 19.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixAddScalar() throws Exception {
        Var var = parser.calc("{{12,13},{14,15}+6");
        String expected = "{{18.0, 19.0}, {19.0, 20.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Var var = parser.calc("22-4");
        double expected = 18.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorSubVector() throws Exception {
        Var var = parser.calc("{22,23}-{4,5}");
        String expected = "{18.0, 18.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorSubScalar() throws Exception {
        Var var = parser.calc("{22,23}-4");
        String expected = "{18.0, 19.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixSubMatrix() throws Exception {
        Var var = parser.calc("{{22,23},{24,25}}-{{4,5},{6,7}}");
        String expected = "{{18.0, 18.0}, {18.0, 18.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarMulScalar() throws Exception {
        Var var = parser.calc("2*3");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorMulScalar() throws Exception {
        Var var = parser.calc("{2,3}*3");
        String expected = "{6.0, 9.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorMulVector() throws Exception {
        Var var = parser.calc("{2,3}*{3,4}");
        double expected = 18.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual);
    }

    @Test
    public void matrixMulScalar() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}*3");
        String expected = "{{6.0, 9.0}, {12.0, 15.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixMulVector() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}*{3,4}");
        String expected = "{18.0, 32.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixMulMatrix() throws Exception {
        Var var = parser.calc("{{1,2},{3,4}}*{{1,2},{3,4}}");
        String expected = "{{7.0, 10.0}, {15.0, 22.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarDivScalar() throws Exception {
        Var var = parser.calc("3/6");
        double expected = 0.5;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorDivScalar() throws Exception {
        Var var = parser.calc("{3,6}/3");
        String expected = "{1.0, 2.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }
}
