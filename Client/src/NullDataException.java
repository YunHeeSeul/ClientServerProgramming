public class NullDataException extends Exception{
    NullDataException(String errorMessage){
        super(errorMessage);    //우리의 errormessage를 exception 쪽으로 던져줄 수 있다
                                //이건 기본적인 메세지만 떨구는 것이고 이 안에 여러가지를 추가할 수 있음
    }
    public void retry(){//안되면 몇 번을 더 처리해라

    }
}
