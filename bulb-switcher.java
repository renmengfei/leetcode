// 第n个灯，会在它所有的factor轮toggle
//toggle的次数是奇数才会亮
// 什么样的n，factor的个数是奇数? => i^2，因为factor有 (1, i, i^2)
//所以n个灯泡中，有根号n个完全平方数    
public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
