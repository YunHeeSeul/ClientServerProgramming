import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ClientLog extends Formatter{

    public String getHead(Handler h) {return "-------START LOG-------\n";}

    public String format(LogRecord record) {
        StringBuffer sb = new StringBuffer(1000);

        sb.append(calcDate(record.getMillis()));

        sb.append(" [");
        sb.append(record.getLevel());
        sb.append("] ");

        sb.append(record.getSourceMethodName());
        sb.append(" | ");

        sb.append(record.getMessage());
        sb.append("\n");

        return sb.toString();
    }

    public String getTail(Handler h) {return "-------END LOG-------\n";}

    private Object calcDate(long millis) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date resultDate = new Date(millis);
        return dateFormat.format(resultDate);
    }
}
