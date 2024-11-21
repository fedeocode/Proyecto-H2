package fede;

import java.sql.*;

public class bd_h2 {

    public static final String DRIVER = "org.h2.Driver";
    public static final String URL_BD = "jdbc:h2:~/test";
    public static final String USER_BD = "sa";
    public static final String PASS_BD = "";


    private static final String SQL_CREATE = "DROP TABLE IF EXISTS ANIMALES;" +
            "CREATE TABLE ANIMALES(ID INT PRIMARY KEY, NOMBRE VARCHAR(50), EDAD INT ); ";
    private static final String SELECT_SQL = "SELECT * FROM ANIMALES;";


    //sentencias con preparedstatement
    private static final String INSERT_SQL = "INSERT INTO ANIMALES VALUES(?,?,?);";


    public static void main(String[] args) {


        //Objeto a guardar
        Perro perro = new Perro(1L, 5, "salame");

        Connection conexion=null;
        try{
            Class.forName(DRIVER);

            //Se establece la conexion
            conexion= DriverManager.getConnection(URL_BD,USER_BD,PASS_BD);


            //Crea una sentencia de la tabla
            Statement stmt= conexion.createStatement();
            stmt.execute(SQL_CREATE);

            //Inserta un registro en la tabla
            PreparedStatement pstmt= conexion.prepareStatement(INSERT_SQL);

            pstmt.setLong(1,perro.getId());
            pstmt.setString(2,perro.getNombre());
            pstmt.setInt(3,perro.getEdad());


            if(pstmt.executeUpdate() > 0){
                System.out.println("Se guardo el registro");
            }

             //Traemos los registros de la tabla animales
            ResultSet resultadosAnimales= stmt.executeQuery(SELECT_SQL);
            while( resultadosAnimales.next()){


                System.out.println(resultadosAnimales.getLong(1)+
                        " el nombre que trae de la bd de datos es "+
                        resultadosAnimales.getString(2));
            }


        }catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {


            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.getMessage();
            }
        }


    }


}


