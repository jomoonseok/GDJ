package com.gdu.app01.java01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
	@Configuration
	Bean을 만드는 Java 파일
	Spring Bean Configuration File과 하는 일이 같다.
*/

@Configuration
public class SpringBeanConfig {

	// 메소드 하나당 Bean 하나를 맡아서 생성한다.

	/*
	  @Bean Bean을 만드는 메소드 메소드이름이 Bean의 이름(id)이고, 반환타입이 Bean의 타입(class)이다.
	 */

	/*
	  <bean id="song" class="Song"> <property name="title" value="제목1"/> <property
	  name="genre" value="장르1 /> </bean>
	 */
	@Bean
	public Song song1() {
		Song song = new Song();
		song.setTitle("제목1");
		song.setGenre("장르1");
		return song;
	}

	/*
	  <bean id="song" class="Song"> <property name="title" value="제목2"/> <property
	  name="genre" value="장르2 /> </bean>
	 */
	@Bean(name = "song2") // @Bean에 name값을 지정하면 id로 사용된다.
	public Song asdfasdf() { // 메소드 이름은 아무거나 적어도된다.
		Song song = new Song();
		song.setTitle("제목2");
		song.setGenre("장르2");
		return song;
	}

	/*
	  <bean id="song" class="Song"> <constructor-arg value="제목2"/> <constructor-arg
	  value="장르2 /> </bean>
	 */
	@Bean
	public Song song3() {
		return new Song("제목3", "장르3");
	}
	
	// 미션
	// song1를 가지는 singer1을 만들어 보자.
	// setter injection
	@Bean
	public Singer singer1() {
		Singer singer = new Singer();
		singer.setName("가수1");
		singer.setSong(song1());
		return singer;
	}
	
	// song2를 가지는 singer2을 만들어 보자.
	// setter injection
	@Bean(name="singer2")
	public Singer qwerty() {
		Singer singer = new Singer();
		singer.setName("가수2");
		singer.setSong(asdfasdf());
		return singer;
	}
	
	// song3를 가지는 singer3을 만들어 보자.
	// constructor injection
	@Bean
	public Singer singer3() {
		return new Singer("가수3", song3());
	}
	

}
