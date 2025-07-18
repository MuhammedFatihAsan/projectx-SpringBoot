package projectx.northwind.core.utilities.results;

public class Result {

    private boolean success;
    private String message;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success, String message){

        this(success); // this bulunduğu class - tek parametreli cont. çagrıyor - this.success = success; aynı
        this.message = message;
    }

    public boolean isSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }

}
