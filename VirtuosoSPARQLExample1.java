
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.RDFNode;

import virtuoso.jena.driver.*;

public class VirtuosoSPARQLExample1 {

    /*
     * Executes a SPARQL query against a virtuoso url and prints results.
     */
    public static void main(String[] args) {

        String url;
        if(args.length == 0)
            //如果Virtuoso安装在本体，这个是默认的地址和端口
            url = "jdbc:virtuoso://localhost:1111";
        else
            url = args[0];

/*			STEP 1			*/
        //连接服务器，两个“dba”分别是账号和密码，是初始状态Virtuoso的默认值
        VirtGraph set = new VirtGraph (url, "dba", "dba");

/*			STEP 2			*/
/*		Select all data in virtuoso	*/
        //给出查询语句，这里使用的是Jena框架里的
        Query sparql = QueryFactory.create("SELECT * WHERE { GRAPH ?graph { ?s ?p ?o } } limit 100");

/*			STEP 3			*/
        //在服务器"set"上执行查询语句"sparql"
        VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);

        //获取结果，这些就和Jena的操作一模一样了
        ResultSet results = vqe.execSelect();
        while (results.hasNext()) {
            QuerySolution result = results.nextSolution();
            RDFNode graph = result.get("graph");
            RDFNode s = result.get("s");
            RDFNode p = result.get("p");
            RDFNode o = result.get("o");
            System.out.println(graph + " { " + s + " " + p + " " + o + " . }");
        }

        //可以打印结果放到文件里。
    }
}