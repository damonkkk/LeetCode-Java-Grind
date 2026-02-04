package Review.Q5;

import java.util.Random;
/**
 * The class Expression represents an arithmethic expression, made
 * up of integer constants and two binary operators (namely, + and *). The
 * class is abstract: any Expression instance must be an instance
 * of one of the two subclasses Constant or Operator, defined below.
 *
 * You MUST implement the `equals` and `hashCode` methods of the two
 * subclasses.
 *
 * Two Expressions are equal if they represent the exact same expression,
 * including ordering and grouping of terms. For example, 1 + 2 and 2 + 1
 * are not considered equal, even if they evaluate to the same value.
 *
 * Your hash functions do not have to be perfect, but they should be
 * non-trivial (hashing a collection of different Expressions should
 * yield a number of different hash values, although not necessarily
 * as many as the number of Expressions hashed).
 *
 * Remember that two objects that are equal must have the same hash
 * value.
 */
public abstract class Expression {
    /*
     * Returns the value of the Expression.
     */
    public abstract int evaluate();
}

class Constant extends Expression {
    int value;

    Constant(int value) {
        this.value = value;
    }
    @Override
    public int evaluate() {
        return value;
    }
    @Override
    public boolean equals(Object other) {
        if (this ==other){
            return true;
        }
        if (other == null){
            return false;
        }
        if(getClass() != other.getClass()){
            return false;
        }
        Constant a = (Constant) other;
        return value==a.value;
    }
    @Override
    public int hashCode() {
        // for an object that is defined by a single integer the simplest and best hash code is the integer value itself.
        return this.value;
    }
}

enum OperatorType {
    SUM, PRODUCT;

    public String toString() {
        switch (this) {
            case SUM:
                return "+";
            case PRODUCT:
                return "*";
        }
        return "?";
    }
}

class Operator extends Expression {
    OperatorType type;
    Expression left;
    Expression right;

    Operator(OperatorType type, Expression left, Expression right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }
    @Override
    public int evaluate() {
        int lv = left.evaluate();
        int rv = right.evaluate();
        switch (type) {
            case SUM:
                return lv + rv;
            case PRODUCT:
                return lv * rv;
        }
        return 0;
    }
    @Override
    public boolean equals(Object other) {
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(getClass() != other.getClass()){
            return false;
        }
        Operator a = (Operator) other;

         return type.equals(a.type) &&
                        left.equals(a.left ) && right.equals(a.right) ;
    }
    @Override
    public int hashCode() {
        int res = 7;
        res = 17* res + left.hashCode();
        res = 17 * res+right.hashCode();
        res = 17* res + type.hashCode();
        return res;
    }
}