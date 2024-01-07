package a3lachi.dummyspring;

class Results {
    
    String text ;

    public Results(String text) {
        this.text = text ;
    }

    public String getText() {
        return this.text ;
    }

    void setText(String text) {
        this.text = text ;
    }
}


class RapSongs {
    String[] names ;
    String[] rappers;

    public RapSongs(String[] names , String[] rappers) {
        this.names = names ;
        this.rappers = rappers ;
    }

    public String[] getNames() {
        return this.names;
    }

    public String[] getRappers() {
        return this.rappers;
    }
}


class Random {
    String one;
    String two;
    String three;

    public Random(String one, String two, String three) {
        this.one = one ;
        this.two = two ;
        this.three = three ;
    }

    public String getOne() {
        return this.one;
    }

    public String getTwo() {
        return this.two ;
    }

    public String getThree() {
        return this.three; 
    }

    public void setOne(String one) {
        this.one = one ;
    }

    public void setTwo(String two) {
        this.two = two ;
    }

    public void setThree(String three) {
        this.three = three ;
    }
}


class Nested {

    Results rzlt;
    Random rnd ;
    String str ;

    public Nested(Results rzlt , Random rnd, String str) {
        this.rzlt = rzlt ;
        this.rnd = rnd ;
        this.str = str ;
    }

    public String getStr() {
        return this.str ;
    }

    public Results getRzlt() {
        return this.rzlt ;
    }

    public void setRzlt(Results rzlt) {
        this.rzlt = rzlt ;
    }

    public Random getRnd() {
        return this.rnd ;
    }
}

class NestedPost {
    Results load ;
    String status ;

    public NestedPost(Results load, String status) {
        this.load = load ;
        this.status = status ;
    }

    public Results getLoad() {
        return this.load;
    }

    public String getStatus() {
        return this.status ;
    }
}
