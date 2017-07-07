package ch10;

/**
 * Created by scn on 2017/7/7.
 * catch和throws同时使用
 */
public class AuctionTest {
    private double initPrice = 30.0;
    // 因为该方法中显示抛出了AuctionException异常，所以此处需要声明抛出AuctionException异常
    public void bid(String bidPrice) throws AuctionException {
        double d = 0.0;
        try {
            d = Double.parseDouble(bidPrice);
        } catch (Exception e) {
            // 修复处理
            e.printStackTrace();
            // 再次抛出自定义异常
            throw new AuctionException("竞拍价必须是数值，不能包含其他字符！");
        }
        if (initPrice > d) {
            throw new AuctionException("竞拍价比起拍价低，不允许竞拍！");
        }
        initPrice = d;
    }

    public static void main(String[] args) {
        AuctionTest ac = new AuctionTest();
        try {
            ac.bid("df");
        } catch (AuctionException ae) {
            System.out.println("异常：" + ae.getMessage());
        }
    }
}
