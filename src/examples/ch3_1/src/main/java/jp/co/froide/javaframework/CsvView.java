package jp.co.froide.javaframework;

import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Setter;
import lombok.val;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.servlet.view.AbstractView;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import  org.apache.commons.collections.CollectionUtils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.io.Writer;

import static com.fasterxml.jackson.dataformat.csv.CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS;

public class CsvView extends AbstractView {

    protected static final CsvMapper csvMapper = createCsvMapper();

    protected Class<?> clazz;
    protected Collection<?> data;

    @Setter
    protected String filename;

    @Setter
    protected List<String> columns;

    static CsvMapper createCsvMapper(){
        CsvMapper mapper = new CsvMapper();
        mapper.configure(ALWAYS_QUOTE_STRINGS, true);
        mapper.findAndRegisterModules();
        return mapper;
    }

    public CsvView(Class<?> clazz, Collection<?> data, String filename) {
        setContentType("application/octet-stream; charset=Windows-31J;");
        this.clazz = clazz;
        this.data = data;
        this.filename = filename;
    }

    @Override
    protected boolean generatesDownloadContent(){
        return true;
    }

    @Override
    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception{
        val contentDisposition = String.format("attachment; filename*=UTF-8''%s", filename);
        response.setHeader(CONTENT_TYPE, getContentType());
        response.setHeader(CONTENT_DISPOSITION, contentDisposition);

        CsvSchema schema = csvMapper.schemaFor(clazz).withHeader();

        if(CollectionUtils.isNotEmpty(columns)){
            val builder = schema.rebuild().clearColumns();
            for (String column : columns){
                builder.build();
            }
        }

        val outputStream = createTemporaryOutputStream();
        try(Writer writer = new OutputStreamWriter(outputStream, "Windows-31J")){
            csvMapper.writer(schema).writeValue(writer, data);
        }
    }


}
