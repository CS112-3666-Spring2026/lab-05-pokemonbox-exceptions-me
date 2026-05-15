public class PokemonAlreadyExistsException extends Exception {
	public PokemonAlreadyExistsException() {
		super("Pokemon already exists in the box.");
	}

	public PokemonAlreadyExistsException(String message) {
		super(message);
	}
}