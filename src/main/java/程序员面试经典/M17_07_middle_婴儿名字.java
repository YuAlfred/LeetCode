package 程序员面试经典;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.07. 婴儿名字
 * @date: 2020/10/28 5:17 下午
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * <p>
 * 在结果列表中，选择字典序最小的名字作为真实名字。
 * <p>
 * 示例：
 * <p>
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * 提示：
 * <p>
 * names.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baby-names-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_07_middle_婴儿名字 {

    public static void main(String[] args) {
        M17_07_middle_婴儿名字 m = new M17_07_middle_婴儿名字();
        m.trulyMostPopular(new String[]{"Pwsuo(71)", "Prf(48)", "Rgbu(49)", "Zvzm(31)", "Xxcl(25)", "Bbcpth(42)", "Padz(70)", "Jmqqsj(19)", "Uwy(26)", "Jylbla(65)", "Xioal(11)", "Npbu(62)", "Jpftyg(96)", "Tal(46)", "Hnc(100)", "Yldu(85)", "Alqw(45)", "Wbcxi(34)", "Kxjw(36)", "Clplqf(8)", "Fayxe(66)", "Slfwyo(48)", "Xbesji(70)", "Pmbz(22)", "Oip(2)", "Fzoe(63)", "Qync(79)", "Utc(11)", "Sqwejn(19)", "Ngi(8)", "Gsiiyo(60)", "Bcs(73)", "Icsvku(1)", "Yzwm(92)", "Vaakt(21)", "Uvt(70)", "Axaqkm(100)", "Gyhh(84)", "Gaoo(98)", "Ghlj(35)", "Umt(13)", "Nfimij(52)", "Zmeop(77)", "Vje(29)", "Rqa(47)", "Upn(89)", "Zhc(44)", "Slh(66)", "Orpqim(69)", "Vxs(85)", "Gql(19)", "Sfjdjc(62)", "Ccqunq(93)", "Oyo(32)", "Bvnkk(52)", "Pxzfjg(45)", "Kaaht(28)", "Arrugl(57)", "Vqnjg(50)", "Dbufek(63)", "Fshi(62)", "Lvaaz(63)", "Phlto(41)", "Lnow(70)", "Mqgga(31)", "Adlue(82)", "Zqiqe(27)", "Mgs(46)", "Zboes(56)", "Dma(70)", "Jnij(57)", "Ghk(14)", "Mrqlne(39)", "Ljkzhs(35)", "Rmlbnj(42)", "Qszsny(93)", "Aasipa(26)", "Wzt(41)", "Xuzubb(90)", "Maeb(56)", "Mlo(18)", "Rttg(4)", "Kmrev(31)", "Kqjl(39)", "Iggrg(47)", "Mork(88)", "Lwyfn(50)", "Lcp(42)", "Zpm(5)", "Qlvglt(36)", "Liyd(48)", "Jxv(67)", "Xaq(70)", "Tkbn(81)", "Rgd(85)", "Ttj(28)", "Ndc(62)", "Bjfkzo(54)", "Lqrmqh(50)", "Vhdmab(41)"},
            new String[]{"(Uvt,Rqa)", "(Qync,Kqjl)", "(Fayxe,Upn)", "(Maeb,Xaq)", "(Pmbz,Vje)", "(Hnc,Dma)", "(Pwsuo,Gyhh)", "(Gyhh,Aasipa)", "(Fzoe,Lcp)", "(Mgs,Vhdmab)", "(Qync,Rgd)", "(Gql,Liyd)", "(Gyhh,Tkbn)", "(Arrugl,Adlue)", "(Wbcxi,Slfwyo)", "(Yzwm,Vqnjg)", "(Lnow,Vhdmab)", "(Lvaaz,Rttg)", "(Nfimij,Iggrg)", "(Vje,Lqrmqh)", "(Jylbla,Ljkzhs)", "(Jnij,Mlo)", "(Adlue,Zqiqe)", "(Qync,Rttg)", "(Gsiiyo,Vxs)", "(Xxcl,Fzoe)", "(Dbufek,Xaq)", "(Ccqunq,Qszsny)", "(Zmeop,Mork)", "(Qync,Ngi)", "(Zboes,Rmlbnj)", "(Yldu,Jxv)", "(Padz,Gsiiyo)", "(Oip,Utc)", "(Tal,Pxzfjg)", "(Adlue,Zpm)", "(Bbcpth,Mork)", "(Qync,Lvaaz)", "(Pmbz,Qync)", "(Alqw,Ngi)", "(Bcs,Maeb)", "(Rgbu,Zmeop)"});
    }

    class Tree {
        String name;
        Tree parent;
        int times;

        public Tree(String name, int times) {
            this.name = name;
            this.times = times;
            this.parent = null;
        }
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Tree> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String s = names[i];
            String name = s.substring(0, s.indexOf("("));
            String sTimes = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
            map.put(name, new Tree(name, Integer.parseInt(sTimes)));
        }
        for (String s : synonyms) {
            String[] splits = s.split(",");
            String name1 = splits[0].substring(1);
            String name2 = splits[1].substring(0, splits[1].length() - 1);
            if (map.containsKey(name1) && map.containsKey(name2)) {
                Tree parent1 = findRoot(map.get(name1));
                Tree parent2 = findRoot(map.get(name2));
                if (parent1 == parent2) {
                    continue;
                }
                if (parent1.name.compareTo(parent2.name) > 0) {
                    parent1.parent = parent2;
                    parent2.times += parent1.times;
                } else {
                    parent2.parent = parent1;
                    parent1.times += parent2.times;
                }
            }
        }
        List<String> res = new LinkedList<>();
        for (Tree node : map.values()) {
            if (node.parent == null) {
                res.add(node.name + "(" + node.times + ")");
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public Tree findRoot(Tree node) {
        while (node.parent != null) {
            node = node.parent;
        }
        return node;
    }
}






