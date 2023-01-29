

public class Song extends Media {
	
	// TODO complete this class
	// variable(s):
	//  title (String), artist (String), rating (int), genre (Genre)
	// 
	// method(s):
	//  constructor(String, String, int, Genre) - assign to the this.variable(s)
	//  double getPrice() - call the Genre.setPrice(int rating), use rating as argument
	//  override toString() method to display song information
	private String artist;
	private int rating;
	private Genre genre;

	private String title;
	
	public Song(String title, String artist, int rating, Genre genre) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.genre = genre;
	}



	public String getArtist() {
		return artist;
	}
	
	@Override
	public String toString() {
		return (title + " by " + artist + " price at = " + this.price);
	}
	
	// TODO complete the static factory of() method
	// Return a new object if the genre is correct, or throw an IllegalArgumentException with the message "Genre is invalid"
	public static Song of(String title, String artist, int rating, Genre genre) {
		if (genre instanceof Pop || genre instanceof Rock || genre instanceof Rap) {
			return new Song(title, artist, rating, genre);
		} else {
			throw new IllegalArgumentException("Invalid genre for a song");
		}
	}
}
