package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter, @Setter, @ToString 등
@NoArgsConstructor
@AllArgsConstructor
@Builder
// window - show view - outline 무엇을 추가했는지 볼 수 있다.
public class ContactDTO {
	private int contact_no;
	private String name;
	private String tel;
	private String email;
	private Date reg_date;
	
}
