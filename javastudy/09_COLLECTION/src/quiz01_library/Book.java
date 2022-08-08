package quiz01_library;

public class Book {
	private int BookNo;
	private String title; // 사용자입력
	private String author; // 사용자입력

	public Book() {

	}

	public Book(int bookNo, String title, String author) {
		super();
		BookNo = bookNo;
		this.title = title;
		this.author = author;
	}

	public int getBookNo() {
		return BookNo;
	}

	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [BookNo=" + BookNo + ", title=" + title + ", author=" + author + "]";
	}

	@Override  // 객체의 내용을 비교할 때 equals의 Override가 필요하다. 자동완성 Source 메뉴에 있다.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (BookNo != other.BookNo)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
