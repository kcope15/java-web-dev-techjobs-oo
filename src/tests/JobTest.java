package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;

    @Before
    public void createJob() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }

    @Test
    public void testSettingJobId() {
        assertTrue(job1.getId() != job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1 == job2);
    }

    @Test
    public void testToStringHasNewLineBeforeAndAfter() {
        String outputJob1 = job1.toString();
        char firstChar = outputJob1.charAt(0);
        char lastChar = outputJob1.charAt(outputJob1.length()-1);

        assertTrue(firstChar == '\n' && lastChar == '\n');
    }

    @Test
    public void testStringContainsLabelDataOwnLine() {
        String outputJob1 = job1.toString();
        String expectedOutput = "\nID: " + job1.getId() + "\nName: " + "Product tester" + "\nEmployer: " + "ACME" + "\nLocation: " + "Desert" + "\nPosition Type: " + "Quality control" + "\nCore Competency: " + "Persistence" + "\n";

        assertEquals(expectedOutput, outputJob1);
    }

    @Test
    public void testEmptyField() {
        job3.toString();

        assertTrue(job3.getName() != "" || job3.getName().matches("Data not available"));
        assertTrue(job3.getEmployer().getValue() != "" || job3.getEmployer().getValue().matches("Data not available"));
        assertTrue(job3.getLocation().getValue() != "" || job3.getLocation().getValue().matches("Data not available"));
        assertTrue(job3.getPositionType().getValue() != "" || job3.getPositionType().getValue().matches("Data not available"));
        assertTrue(job3.getCoreCompetency().getValue() != "" || job3.getCoreCompetency().getValue().matches("Data not available"));

    }
}





