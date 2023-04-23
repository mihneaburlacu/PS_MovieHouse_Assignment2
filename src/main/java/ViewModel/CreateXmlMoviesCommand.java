package ViewModel;

import Model.DBContextMovie;
import Model.Movie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.List;

public class CreateXmlMoviesCommand  implements ICommand{
    private VMViewAndFilter vmViewAndFilter;

    public CreateXmlMoviesCommand(){}

    public CreateXmlMoviesCommand(VMViewAndFilter vmViewAndFilter) {
        this.vmViewAndFilter = vmViewAndFilter;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();
        List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("Movies");
            document.appendChild(root);

            for (Movie movie : list) {
                Element c = document.createElement("Movie");
                root.appendChild(c);

                Element id = document.createElement("ID");
                id.appendChild(document.createTextNode(movie.getID() + ""));
                c.appendChild(id);

                Element name = document.createElement("Name");
                name.appendChild(document.createTextNode(movie.getName()));
                c.appendChild(name);

                Element type = document.createElement("Type");
                type.appendChild(document.createTextNode(movie.getType().toString()));
                c.appendChild(type);

                Element category = document.createElement("Category");
                category.appendChild(document.createTextNode(movie.getCategory()));
                c.appendChild(category);

                Element year = document.createElement("Year");
                year.appendChild(document.createTextNode(movie.getYear() + ""));
                c.appendChild(year);

                Element idCreator = document.createElement("IDCreator");
                idCreator.appendChild(document.createTextNode(movie.getIdCreator() + ""));
                c.appendChild(idCreator);

            }

            File xmlFile = new File("Movies.xml");
            javax.xml.transform.TransformerFactory transformerFactory= javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
