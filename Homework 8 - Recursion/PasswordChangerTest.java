import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PasswordChangerTest {
	@Test
	public void containsDigitTest() {
		PasswordChanger passwordChanger = new PasswordChanger();

		// Input
		String input = "";
		// Expected
		boolean expected = false;
		// Actual
		boolean actual = passwordChanger.containsDigit(input);
		Assert.assertTrue(expected == actual);

		// Input
		input = "Password123";
		// Expected
		expected = true;
		// Actual
		actual = passwordChanger.containsDigit(input);
		Assert.assertTrue(expected == actual);

		// Input
		input = "123Password";
		// Expected
		expected = true;
		// Actual
		actual = passwordChanger.containsDigit(input);
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void equalsOldTest() 
	{
		PasswordChanger passwordChanger = new PasswordChanger();

		// Input
		String oldPassword = "P";
		String newPassword = "P";
		// Expected
		boolean expected = true;
		// Actual
		boolean actual = passwordChanger.equalsOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "";
		newPassword = "";
		//Expected
		expected = true;
		//Actual
		actual = passwordChanger.equalsOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "Long";
		newPassword = "Longer";
		//Expected
		expected = false;
		//Actual
		actual = passwordChanger.equalsOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "Password";
		newPassword = "PassworD";
		//Expected
		expected = false;
		//Actual
		actual = passwordChanger.equalsOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "password";
		newPassword = "Password";
		//Expected
		expected = false;
		//Actual
		actual = passwordChanger.equalsOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "password";
		newPassword = "passWord";
		//Expected
		expected = false;
		//Actual
		actual = passwordChanger.equalsOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void reverseOfOldTest() 
	{
		PasswordChanger passwordChanger = new PasswordChanger();

		// Input
		String oldPassword = "";
		String newPassword = "";
		// Expected
		boolean expected = true;
		// Actual
		boolean actual = passwordChanger.reverseOfOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		// Input
		oldPassword = "Password";
		newPassword = "drowssaP";
		// Expected
		expected = true;
		// Actual
		actual = passwordChanger.reverseOfOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		// Input
		oldPassword = "Pass";
		newPassword = "Word";
		// Expected
		expected = false;
		// Actual
		actual = passwordChanger.reverseOfOld(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void numberDifferencesTest() 
	{
		PasswordChanger passwordChanger = new PasswordChanger();

		//Input
		String oldPassword = "";
		String newPassword = "";
		//Expected
		int expected = 0;
		//Actual
		int actual = passwordChanger.numberDifferences(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input 
		oldPassword = "P";
		newPassword = "P";
		//Expected 
		expected = 0; 
		//Actual 
		actual = passwordChanger.numberDifferences(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input 
		oldPassword = "P";
		newPassword = "p";
		//Expected 
		expected = 1; 
		//Actual 
		actual = passwordChanger.numberDifferences(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);
		
		//Input
		oldPassword = "Long";
		newPassword = "Longer";
		//Expected
		expected = 2;
		//Actual
		actual = passwordChanger.numberDifferences(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "Longer";
		newPassword = "Long";
		//Expected
		expected = 2;
		//Actual
		actual = passwordChanger.numberDifferences(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		//Input
		oldPassword = "oldPassword";
		newPassword = "newPassword";
		//Expected
		expected = 3;
		//Actual
		actual = passwordChanger.numberDifferences(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void differentEnoughTest() 
	{
		PasswordChanger passwordChanger = new PasswordChanger();

		// Input
		String oldPassword = "oldPassword";
		String newPassword = "newPassword";
		int quality = 3;
		// Expected
		boolean expected = true;
		// Actual
		boolean actual = passwordChanger.differentEnough(oldPassword, newPassword, quality);
		Assert.assertTrue(expected == actual);

		// Input
		oldPassword = "oldPassword";
		newPassword = "newPassword";
		quality = 4;
		// Expected
		expected = false;
		// Actual
		actual = passwordChanger.differentEnough(oldPassword, newPassword, quality);
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void validPasswordChangeTest() 
	{
		PasswordChanger passwordChanger = new PasswordChanger();

		// Input
		String oldPassword = "oldPassword!54321";
		String newPassword = "newPassword12345!";
		// Expected
		boolean expected = true;
		// Actual
		boolean actual = passwordChanger.validPasswordChange(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);

		// Input
		oldPassword = "wow";
		newPassword = "wow";
		// Expected
		expected = false;
		// Actual
		actual = passwordChanger.validPasswordChange(oldPassword, newPassword);
		Assert.assertTrue(expected == actual);
	}
}
