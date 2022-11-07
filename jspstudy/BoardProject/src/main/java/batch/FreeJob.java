package batch;

import java.io.File;
import java.io.PrintWriter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDao;

public class FreeJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		Free free = FreeDao.getInstance().freeTop();
		
		File file = new File("C:\\GDJ\\jspstudy\\BoardProject","top.txt");
		
		PrintWriter out = null;
		
		try {
			
			out = new PrintWriter(file);
			
			out.println("게시글번호 " + free.getFreeNo());
			out.println("작성자 " + free.getWriter());
			out.println("제목 " + free.getTitle());
			out.println("작성IP " + free.getIp());
			out.println("조회수 " + free.getHit());
			out.println("내용");
			out.println(free.getContent());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
