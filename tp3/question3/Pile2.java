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
        if (taille <= 0)
            taille = this.CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide()) throw new PileVideException();
        return this.stk.peek();
    }

    public boolean estVide() {
        return this.stk.isEmpty();
    }
    
    public boolean estPleine() {
        return this.taille() == this.capacite();
    }
    
    public int capacite() {
        return this.capacite;
    }
    
    public int taille() {
        return this.stk.size();
    }
    
    public String toString() {
        Object[] arr = this.stk.toArray();
        String s = "[";
        for(int i = arr.length - 1; i >= 0; i--){
            s += arr[i].toString();
            if(i > 0) s += ", ";
        }
        return s + "]";
    }
    
    public boolean equals(Object o) {
        if (o instanceof Pile2) {
            Pile2 tempPile = (Pile2) o;
           return this.capacite() == tempPile.capacite()
          && this.hashCode() == tempPile.hashCode();
        }
        return false;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }

} // Pile2