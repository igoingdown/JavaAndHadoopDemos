package virtuoso_test;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

public class VirtuosoExample {
    public static void main(String[] args) {
        String url;
        if(args.length == 0)
            url = "jdbc:virtuoso://10.109.247.136:1111";
        else
            url = args[0];
        VirtGraph set = new VirtGraph (url, "dba", "dba");
        StringBuffer qStringBuffer = new StringBuffer();
        qStringBuffer.append("PREFIX ns:<http://rdf.freebase.com/ns/> ")
                .append("SELECT DISTINCT ?p WHERE { GRAPH ?graph {ns:m.02w79vz ?p ?o} }");
        VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (qStringBuffer.toString(), set);
        ResultSet results = vqe.execSelect();
        while (results.hasNext()) {
            QuerySolution result = results.nextSolution();
            RDFNode p = result.get("p");
            RDFNode o = result.get("o");
            System.out.println(" { " + p + " " + o + " . }");
        }
    }
}



