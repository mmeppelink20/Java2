package lambda;

public interface MyNumPredicates <T extends Number> {

    public static <T extends Number> boolean isPrime(T n) {
        if(n.intValue() < 2) {
            return false;
        }
        for(int i = 2; i <= n.intValue() / i; i++) {
            if((n.intValue() % i) == 0) {
                return false;
            }
        }
        return true;
    }

}
