package org.wrex.scheduleTasks;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * An example of scheduled job.
 * See more at http://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html
 * @author ggefaell
 *
 */
@Component
public class SendDailyUpdates {

	  @Scheduled(fixedRate = 500000)
	    public void reportCurrentTime() {
	    }
}
