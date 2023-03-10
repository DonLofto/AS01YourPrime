
import org.junit.jupiter.api.DisplayName;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class YourPrimeTest {

	public static void main(String[] args) {
		// dummy songs
		Song s1 = Song.of("Fight The Power", "Public Enemy", 4, new Rap());
		Song s2 = Song.of("Smell Like Teen Spirit", "Nirvana", 4, new Rock());
		Song s3 = Song.of("Blinding Lights", "The Weeknd", 2, new Pop());
		Song s4 = Song.of("We Belong Together", "Mariah Carey", 3, new Pop());
		Song s5 = Song.of("Hey Jude", "The Beatles", 3, new Rock());

		// dummy movies
		Movie m1 = Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Drama());
		Movie m2 = Movie.of("Avangers: Endgame", "Ironman, Capt. America, Thor", 181.0, 2019, 2, new Action());
		Movie m3 = Movie.of("Zoolander", "Ben Stiller, Owen Wilson", 90.0, 1998, 1, new Comedy());
		Movie m4 = Movie.of("The Shawshank Redemption", "Tim Robbins, Morgan Freeman", 142.0, 1994, 5, new Drama());
		Movie m5 = Movie.of("Forrest Gump", "Tom Hanks", 142.5, 1994, 3, new Comedy());
		Movie m6 = Movie.of("The Dark Knight", "Christian Bale, Heath Ledger", 152.0, 2008, 5, new Rock());

		// dummy books
		Book b1 = Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Fantasy());
		Book b2 = Book.of("Harry Potter and the Deathly Hallows", "J. K. Rowlings", 2007, 3, 607, new Fantasy());
		Book b3 = Book.of("Show Dog", "Phil Knight", 2016, 5, 399, new Autobiography());
		Book b4 = Book.of("The Fellowship of the Ring", "J. R. R. Tolkien", 1954, 2, 423, new Fantasy());
		Book b5 = Book.of("Surely You're Jocking, Mr. Feynman", "Richard P. Feynman", 1985, 5, 356, new Autobiography());
		Book b6 = Book.of("Oliver Twist", "Charles Dickens", 1838, 5, 608, new Rock());

		// create subscribers for testing purpose
		// user A12345
		List<Movie> listMovie01 = new ArrayList<>();
		List<Movie> listM = Arrays.asList(m1, m2, m4);
		listMovie01.addAll(listM);

		List<Book> listBook01 = new ArrayList<>();
		List<Book> listB = Arrays.asList(b1, b4, b6);
		listBook01.addAll(listB);

		List<Song> listSong01 = new ArrayList<>();
		List<Song> listS = Arrays.asList(s3, s2, s4);
		listSong01.addAll(listS);

		MyMedia myMedia01 = new MyMedia(listMovie01, listBook01, listSong01);
		Subscriber user1 = new Subscriber("A12345", "John Doe", myMedia01);
		System.out.println(user1.toString());

		// user A67890
		List<Movie> listMovie02 = new ArrayList<>();
		listM = Arrays.asList(m5, m4, m3, m2, m6);
		listMovie02.addAll(listM);

		List<Book> listBook02 = new ArrayList<>();
		listB = Arrays.asList(b1, b4, b5, b3, b2);
		listBook02.addAll(listB);

		List<Song> listSong02 = new ArrayList<>();
		listS = Arrays.asList(s1, s4, s5, s2);
		listSong02.addAll(listS);

		MyMedia myMedia02 = new MyMedia(listMovie02, listBook02, listSong02);
		Subscriber user2 = new Subscriber("A67890", "Jane Doe", myMedia02);
		System.out.println(user2.toString());

		// Testing the sorting function
		System.out.println("Testing for sorting method: ");

		String[] orderType = new String[] {"Price", "Rating", "Duration", "Pages", "Author", "Artist"};
		for (int i = 0; i < orderType.length; i++) {
			System.out.println("\nSorting by: " + orderType[i]);
			List<?> listtmp = user2.sort(orderType[i]);
			for (Object o: listtmp) {
				System.out.println(o.toString());
			}
		}
	}




	@Test
	@DisplayName("Testing for constructor validation: Movie")
	public void validityTestForMovie() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Rap()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Rock()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Pop()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Fantasy()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Autobiography()));
		assertEquals("Genre is invalid", exception.getMessage());
	}

	@Test
	@DisplayName("Testing for constructor validation: Song")
	public void validityTestForSong() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Drama()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Comedy()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Fantasy()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Autobiography()));
		assertEquals("Genre is invalid", exception.getMessage());
	}

	@Test
	@DisplayName("Testing for constructor validation: Book")
	public void validityTestForBook() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Rap()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Rock()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Pop()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Drama()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Action()));
		assertEquals("Genre is invalid", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Comedy()));
		assertEquals("Genre is invalid", exception.getMessage());
	}



}