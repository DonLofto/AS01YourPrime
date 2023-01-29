

public class Comedy extends Genre {


	@Override
	double setPrice(int rating) {
		// TODO Auto-generated method stub
		if (rating > 3) {
			return 1.99;
		} else if (rating == 3) {
			return 0.99;
		}
		return 0.00;
	}

}
