import javax.lang.model.util.ElementScanner6;
public class PasswordChanger implements PWCInterface 
{
	/**
	 * Determines if the password contains at least one character that is a digit (0 through 9)
	 * 
	 * @param password
	 * @return true if password contains a digit (0 through 9) and false if otherwise
	 */
	@Override
	public boolean containsDigit(String password) 
	{
		int passwordLength = password.length();
		if (passwordLength == 0) // Base Case
			return false;
		else if (Character.isDigit(password.charAt(passwordLength - 1))) // Test
			return true;
		else // Recursive Case
			return containsDigit(password.substring(0, passwordLength - 1));
	}
	/**
	 * Determines if the newPassword is equal to the oldPassword
	 * 
	 * @param oldPassword newPassword
	 * @return true if newPassword and oldPassword are the same and false if otherwise
	 */
	@Override
	public boolean equalsOld(String oldPassword, String newPassword) 
	{
		if(oldPassword.length() == 1 && newPassword.length() == 1) //Base Case
			return oldPassword.charAt(0) == newPassword.charAt(0);
		else //Recursive Case
		{
			if(oldPassword.isEmpty() && newPassword.isEmpty())
				return true;
			else if(oldPassword.length() != newPassword.length())
				return false;
			else
			{
				if(oldPassword.charAt(oldPassword.length() - 1) == newPassword.charAt(newPassword.length() - 1))
					return equalsOld(oldPassword.substring(0, oldPassword.length() - 1), newPassword.substring(0, newPassword.length() - 1));
				else
					return false;
			}
		}	
	}
	/**
	 * Determines if the newPassword is equal to the oldPassword in reverse order
	 * 
	 * @param oldPassword newPassword 
	 * @return true if the newPassword is equal to the oldPassword in reverse order and false if otherwise
	 */
	@Override
	public boolean reverseOfOld(String oldPassword, String newPassword) 
	{
		if (oldPassword.length() <= 1 && newPassword.length() <= 1) // Base Case
			return oldPassword.equals(newPassword);
		else // Recursive Case
		{
			char newPasswordFirst = newPassword.charAt(0);
			char oldPasswordLast = oldPassword.charAt(oldPassword.length() - 1);
			if (newPasswordFirst == oldPasswordLast) 
			{
				String shorterNewPassword = newPassword.substring(1, newPassword.length() - 1);
				String shorterOldPassword = oldPassword.substring(1, oldPassword.length() - 1);
				return reverseOfOld(shorterOldPassword, shorterNewPassword);
			} 
			else
				return false;
		}
	}
	/**
	 * Counts the number of character positions where the two passwords (oldPassword and newPassword) differ
	 * 
	 * @param oldPassword newPassword
	 * @return the number (int) of character positions where the two passwords differ
	 */
	@Override
	public int numberDifferences(String oldPassword, String newPassword) 
	{
		if(oldPassword.isEmpty() && newPassword.isEmpty()) //Always 0
			return 0;
		else if(oldPassword.length() == 1 && newPassword.length() == 1) //Base Case
		{
			if (oldPassword.charAt(0) != newPassword.charAt(0))
				return 1;
			else
				return 0;
		} 
		else //Recursive Case
		{
			if(oldPassword.length() != newPassword.length())
			{
				int lengthDifference = Math.abs(oldPassword.length() - newPassword.length());
				if(oldPassword.length() > newPassword.length())
				{
					String shorterOldPassword = oldPassword.substring(0, oldPassword.length() - lengthDifference);
					return lengthDifference + numberDifferences(shorterOldPassword, newPassword);
				}
				else
				{
					String shorterNewPassword = newPassword.substring(0, newPassword.length() - lengthDifference);
					return lengthDifference + numberDifferences(oldPassword, shorterNewPassword);
				}
			}
			else
			{
				if(!oldPassword.isEmpty() && !newPassword.isEmpty())
				{
					if(oldPassword.charAt(oldPassword.length() - 1) != newPassword.charAt(newPassword.length() - 1))
						return 1 + numberDifferences(oldPassword.substring(0, oldPassword.length() - 1), newPassword.substring(0, newPassword.length() - 1));
					else
						return 0 + numberDifferences(oldPassword.substring(0, oldPassword.length() - 1), newPassword.substring(0, newPassword.length() - 1));
				}
				else
					return 0;
			}
		}
	}
	/**
	 * Determines if the newPassword differs from the oldPassword by at least
	 * quality number of characters
	 * 
	 * @param oldPassword newPassword quality
	 * @return true if newPassword differs from oldPassword by at least quality number of characters, and false if otherwise
	 */
	@Override
	public boolean differentEnough(String oldPassword, String newPassword, int quality) 
	{
		if(numberDifferences(oldPassword, newPassword) >= quality)
			return true;
		else
			return false;
	}
	/**
	 * Determines if the user is allowed to changed the oldPassword to the
	 * newPassword. An oldPassword change is allowed if the newPassword contains at
	 * least 1 digit, if the newPassword isn't the oldPassword or the oldPassword in
	 * reverse order, and if the newPassword differs from the oldPassword in at
	 * least half of it's character positions.
	 * 
	 * @param oldPassword newPassword
	 * @return true if the password change is valid, and false if otherwise
	 */
	@Override
	public boolean validPasswordChange(String oldPassword, String newPassword) 
	{
		if ((containsDigit(newPassword)) && (equalsOld(oldPassword, newPassword) == false) && (reverseOfOld(oldPassword, newPassword) == false) && (differentEnough(oldPassword, newPassword, newPassword.length() / 2)))
			return true;
		else
			return false;
	}
}
