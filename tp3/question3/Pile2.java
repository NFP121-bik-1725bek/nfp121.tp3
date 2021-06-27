package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille < 0) {
            this.stk = (T[]) new Object[super.CAPACITE_PAR_DEFAUT];
        } else {
            this.stk = (T[]) new Object[taille];
        }
        this.capacite = 0;
        return this;
    }

    public Pile2(){
        return this;
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk[capacite++] = o;
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        T o = stack[capacite--];
        stk[capacite + 1] = null;
        return o;
    }

    public T sommet() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        T o = stk[capacite];
        return o;
    }

    public int capacite() {
        return this.stk.length;
    }

    public int taille() {
        return this.capacite;
    }

    public boolean estVide() {
        return this.capacite == 0;
    }

    public boolean estPleine() {
        return this.capacite == this.stk.length;
    }

    public boolean equals(Pile2 p) {
        if (this.stk.length != p.stk.length)
            return false;
        if (this.capacite != p.capacite)
            return false;
        for (int i = ptr; i >= 0; i++) {
            if (!this.depiler().equals(p.depiler()))
                return false;
        }
        return true;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = capacite - 1; i >= 0; i--) {
            sb.append(stk[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
} // Pile2