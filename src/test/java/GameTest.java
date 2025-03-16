import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldRegisterPlayers() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 100);
        game.register(player1);

        assertEquals(0, game.round("Alice", "Alice")); // ничья
    }

    @Test
    void shouldThrowExceptionIfPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 100);
        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> game.round("Alice", "Bob"));
        assertThrows(NotRegisteredException.class, () -> game.round("Bob", "Alice"));
    }

    @Test
    void shouldReturn1IfFirstPlayerStronger() {
        Game game = new Game();
        Player alice = new Player(1, "Alice", 100);
        Player bob = new Player(2, "Bob", 80);
        game.register(alice);
        game.register(bob);

        assertEquals(1, game.round("Alice", "Bob"));
    }

    @Test
    void shouldReturn2IfSecondPlayerStronger() {
        Game game = new Game();
        Player alice = new Player(1, "Alice", 80);
        Player bob = new Player(2, "Bob", 100);
        game.register(alice);
        game.register(bob);

        assertEquals(2, game.round("Alice", "Bob"));
    }

    @Test
    void shouldReturn0IfEqualStrength() {
        Game game = new Game();
        Player alice = new Player(1, "Alice", 100);
        Player bob = new Player(2, "Bob", 100);
        game.register(alice);
        game.register(bob);

        assertEquals(0, game.round("Alice", "Bob"));
    }
}
