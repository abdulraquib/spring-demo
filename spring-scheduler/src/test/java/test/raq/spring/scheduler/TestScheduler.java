package test.raq.spring.scheduler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raq.spring.schduler.PojoTask;

//http://docs.spring.io/spring-batch/reference/html/testing.html
//https://github.com/junit-team/junit4/wiki/Test-runners
//https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring-schedulers.xml" })
public class TestScheduler {

	@Autowired
	private PojoTask springPojo;

	
/*	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
    public void testJob() throws Exception {
        simpleJdbcTemplate.update("delete from CUSTOMER");
        for (int i = 1; i <= 10; i++) {
            simpleJdbcTemplate.update("insert into CUSTOMER values (?, 0, ?, 100000)",
                                      i, "customer" + i);
        }

        JobExecution jobExecution = jobLauncherTestUtils.launchJob().getStatus();


        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus());
    }
    */
	
	@Test
	public void testSomething(){
			springPojo.execute();
			assertEquals("Strings are not equal","Hello","Hello");
	}
}
