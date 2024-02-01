package af.cmr.indyli.akademia.business.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class DateUtils {
    public static long calculateDateDifferenceInDays(Date date1, Date date2) {
        long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}
