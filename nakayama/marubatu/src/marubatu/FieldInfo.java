package marubatu;

public enum FieldInfo
{
    NONE,
    MARU,
    BATU;

	public String toString()
	{
		if(this == MARU)
			return "〇";

		if(this == BATU)
			return "×";

		return "・";
	}
}
