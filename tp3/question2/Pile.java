package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille < 0) {
            System.out.println("Cannot create an array with negative size!");
        } else {
            this.zone = new Object[taille];
            this.ptr = 0;
        }
        return this;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Object o = zone[ptr];
        return o;
    }

    public int capacite() {
        return this.zone.length;
    }

    public int taille() {
        return this.ptr;
    }

    public boolean estVide() {
        return this.ptr == 0;
    }

    public boolean estPleine() {
        return this.ptr == this.zone.length;
    }

    public boolean equals(Pile p) {
        if (this.zone.length != p.zone.length)
            return false;
        if (this.ptr != p.ptr)
            return false;
        for (int i = ptr; i >= 0; i++) {
            if (!this.depiler().equals(p.depiler()))
                return false;
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}