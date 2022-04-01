/** The Actor class represents a person in the IMDB database of actors. */
class Actor implements Comparable<Actor> 
{
	/** The unique alphanumeric idenifier of the Actor. */
	private String nconst;

	/** The name by which the Actor is most often credited. */
	private String primaryName;

	/** The year in which the Actor was born, in YYYY format. */
	private String birthYear;

	/** The year in which the Actor died, in YYYY format (if applicable). */
	private String deathYear;

	/** The primary profession of the Actor. */
	private String primaryProfession;

	/** The movie titles for which the Actor is most known. */
	private String knownForTitles;

	/** Default Constructor: Initializes the Actor's instance variables with default values. */
	public Actor() 
	{
		//Default nconst
		nconst = "No identifer yet"; 

		//Default primaryName
		primaryName = "No name yet"; 

		//Default birthYear
		birthYear = "YYYY"; 

		//Default deathYear
		deathYear = "YYYY"; 

		//Default primaryProfession
		primaryProfession = "No primary profession yet"; 

		//Default knownForTitles
		knownForTitles = "Not known for any movies yet";
	}

	/**
	 * Overloaded Constructor: Initializes the Actor's primaryName with the given parameter. 
	 * @param primaryName The name by which the Actor is most often credited.
	 */
	public Actor(String primaryName) 
	{
		this.primaryName = primaryName;
	}

	/**
	 * Overloaded Constructor: Initializes the Actor's instance variables with the given parameters.
	 * @param nconst The unique alphanumeric idenifier of the Actor.
	 * @param primaryName The name by which the Actor is most often credited.
	 * @param birthYear The year in which the Actor was born, in YYYY format.
	 * @param deathYear The year in which the Actor died, in YYYY format (if applicable).
	 * @param primaryProfession The primary profession of the Actor.
	 * @param knownForTitles The movie titles for which the Actor is most known.
	 */
	public Actor(String nconst, String primaryName, String birthYear, String deathYear, String primaryProfession, String knownForTitles) 
	{
		//Initialize the Actor's nconst with the given parameter
		this.nconst = nconst;

		//Initialize the Actor's primaryName with the given parameter
		this.primaryName = primaryName;

		//Initialize the Actor's birthYear with the given parameter
		this.birthYear = birthYear;

		//Initialize the Actor's deathYear with the given parameter
		this.deathYear = deathYear;

		//Initialize the Actor's primaryProfession with the given parameter
		this.primaryProfession = primaryProfession;

		//Initialize the Actor's knownForTitles with the given parameter
		this.knownForTitles = knownForTitles;
	}

	/**
	 * Compares the calling Actor to the given Object parameter.
	 * @param object An instance of the class Object.
	 * @return True if the calling Actor has the same primaryName as the given Object parameter, and false if otherwise. 
	 */
	@Override
	public boolean equals(Object object) 
	{
		//If the Object is not an Actor or null
		if(!(object instanceof Actor))
		{
			//Then return false
			return false;
		}

		//Type cast the Object to type Actor
		Actor otherActor = (Actor)object;

		//Return true if the calling Actor and otherActor have the same primaryName, and false if otherwise
		return this.primaryName.equals(otherActor.primaryName);
	}

	/**
	 * Compares the calling Actor's primaryName to the primaryName of the given Actor parameter. 
	 * @param actor An instance of the Actor class. 
	 * @return The lexicographic ordering of the calling Actor's primaryName and the given Actor parameter's primaryName.
	 */
	@Override
	public int compareTo(Actor actor) 
	{
		//Compare (lexicographically) the calling Actor's primaryName to the primaryName of the given Actor parameter
		return this.primaryName.compareTo(actor.primaryName);
	}

	/**
	 * Getter method for the nconst instance variable. 
	 * @return The calling Actor's nconst.
	 */
	public String getNconst() 
	{
		//Return the calling Actor's nconst
		return nconst;
	}

	/**
	 * Setter method for the nconst instance variable. 
	 * @param nconst The unique alphanumeric idenifier of the Actor.
	 */
	public void setNconst(String nconst) 
	{
		//Set the calling Actor's nconst = the given nconst parameter
		this.nconst = nconst;
	}

	/**
	 * @return the primaryName
	 */
	public String getPrimaryName() {
		return primaryName;
	}

	/**
	 * @param primaryName the primaryName to set
	 */
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	/**
	 * @return the birthYear
	 */
	public String getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * @return the deathYear
	 */
	public String getDeathYear() {
		return deathYear;
	}

	/**
	 * @param deathYear the deathYear to set
	 */
	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}

	/**
	 * @return the primaryProfession
	 */
	public String getPrimaryProfession() {
		return primaryProfession;
	}

	/**
	 * @param primaryProfession the primaryProfession to set
	 */
	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}

	/**
	 * @return the knownForTitles
	 */
	public String getKnownForTitles() {
		return knownForTitles;
	}

	/**
	 * @param knownForTitles the knownForTitles to set
	 */
	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor [nconst=" + nconst + ", primaryName=" + primaryName + ", birthYear=" + birthYear
				+ ", deathYear=" + deathYear + ", primaryProfession=" + primaryProfession + ", knownForTitles="
				+ knownForTitles + "]";
	}
}