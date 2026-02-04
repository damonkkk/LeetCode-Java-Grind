package Review.Q5;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a BoardGame, which is uniquely identified by a combination of genre, name
 * and year published.
 */
public class BoardGame {

    public enum Genre {
        CARD, SOCIAL_DECEPTION, CHILDREN, COOPERATIVE, STRATEGY, CAMPAIGN, DECK_BUILDING,
        DUNGEON_CRAWLER, PARTY, DEXTERITY, EURO, AREA_CONTROL, CLASSIC
    }

    /**
     * The genre of a board game may be any value from the Genre enum
     */
    Genre genre;

    /**
     * The name of a board game is a String of ASCII characters
     */
    String name;

    /**
     * The year the game was published is any number from 2000 to 2022 inclusive
     */
    int year;

    public BoardGame(String name, Genre genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    /**
     * @return a hash code value for this board game. In implementing this method, you may *not* use
     * the default Java implementations in Object.hashCode() or Objects.hash().
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        int res = 7;
        res =17* res +year;
        res =17* res + (genre != null ? genre.hashCode() : 0);
        res = 17* res+ (name != null ? name.hashCode() : 0);
        return res;
    }

    /**
     * @return true if other object is a BoardGame and their fields are equal
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if(this == object){
            return true;
        }
        if(object==null || getClass() != object.getClass()){
            return false;
        }
        BoardGame a = (BoardGame) object;
        return year == a.year &&
                Objects.equals(genre, a.genre) &&  // Null-safe
                Objects.equals(name, a.name);      // Null-safe
    }

    @Override
    public String toString() {
        String g = null;
        if (genre != null) {
            g = genre.toString();
        }
        return name + ", " + g + ", " + year;
    }
}
