package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;

public class V00_000_003__Insert_UserTable extends BaseJavaMigration {

    private static final String PATH = "src/main/resources/db/migration/seed/V00_000_003__Insert_UserTable.csv";
    private static final String DB_NAME = "sample_db";
    private static final String TABLE_NAME = "t_user";
    private static final String INSERT_USER = "flyway";
    private static final String SEPARATOR = ",";

    public void migrate(Context context) throws Exception {

        Path path = Paths.get(PATH);

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] columns = line.split(SEPARATOR);

                String userId = columns[0];
                String displayName = columns[1];

                StringBuilder sql = new StringBuilder();
                sql.append("INSERT ");
                sql.append("INTO " + DB_NAME + "." + TABLE_NAME + " ");
                sql.append("VALUES ( ");
                sql.append("    ?");
                sql.append("  , ?");
                sql.append("  , current_timestamp");
                sql.append("  , '" + INSERT_USER + "'");
                sql.append("  , current_timestamp");
                sql.append("  , '" + INSERT_USER + "'");
                sql.append(");");

                try (PreparedStatement pstmt = context.getConnection().prepareStatement(sql.toString())) {
                    pstmt.setString(1, userId);
                    pstmt.setString(2, displayName);
                    pstmt.execute();
                }
            }
        }
    }
}