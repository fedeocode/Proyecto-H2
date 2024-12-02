package fede;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class bd_h2 {

    public static final String DRIVER = "org.h2.Driver";
    public static final String URL_BD = "jdbc:h2:~/test";
    public static final String USER_BD = "sa";
    public static final String PASS_BD = "";


    private static final String CREATE_SQL="DROP TABLE IF EXISTS EMPLEADOS;"+
            "CREATE TABLE EMPLEADOS(ID INT PRIMARY KEY, NOMBRE VARCHAR(50), EDAD INT,FECHAINICIADA VARCHAR(50),SUELDOBASICO DOUBLE,SUELDOTOTAL DOUBLE ); ";
    private static final String SELECT_SQL="SELECT * FROM EMPLEADOS;";
    private static final String UPDATE_SQL="UPDATE EMPLEADOS SET EDAD=? WHERE  ID=? ;";
    private static final String DELETE_SQL="DELETE EMPLEADOS SET EDAD=? WHERE ID=?;";

    //sentencias con preparedstatement
    private static final String INSERT_SQL = "INSERT INTO EMPLEADOS VALUES(?,?,?,?,?,?);";


    public static void main(String[] args) throws noHabilitadoExeption {


        //Objeto a guardar
        Empleado empleado=new Empleado(7L,"fede",9,"27/4/2005",200.0,400.0);
        Empleado empleado1=new Empleado(5L,"juan",89,"23/2/2009",300.9,300.0);
        Empleado empleado2=new Empleado(4L,"claudio",84,"24/6/2009",305.9,308.0);

       Set<Empleado> empleadoSet=new HashSet<>();
       empleadoSet.add(empleado);
       empleadoSet.add(empleado1);
       empleadoSet.add(empleado2);


        empleado.calcularSueldoTotal(empleado.getHabilitado());


        Connection conexion=null;
        try{
            Class.forName(DRIVER);

            //Se establece la conexion
            conexion= DriverManager.getConnection(URL_BD,USER_BD,PASS_BD);


            //Crea una sentencia de la tabla
            Statement stmt= conexion.createStatement();
            stmt.execute(CREATE_SQL);

            Statement stmt2= conexion.createStatement();
            stmt.execute(SELECT_SQL);

            Statement stmt3= conexion.createStatement();
            stmt.execute(UPDATE_SQL);

            Statement stmt4= conexion.createStatement();
            stmt.execute(DELETE_SQL);

            //Inserta un registro en la tabla
            PreparedStatement pstmt= conexion.prepareStatement(INSERT_SQL);

            pstmt.setLong(1,empleado.getId());
            pstmt.setString(2,empleado.getNombre());
            pstmt.setInt(3,empleado.getEdad());
            pstmt.setString(4,empleado.getFechaIniciada());
            pstmt.setDouble(5,empleado.getSueldoBAsico());
            pstmt.setDouble(6,empleado.getSueldoTotal());

            if(pstmt.executeUpdate() > 0){
                System.out.println("Se guardo el registro");
            }

             //Traemos los registros de la tabla empleados
            ResultSet resultadoEmpleados= stmt.executeQuery(SELECT_SQL);
            ResultSet resultadoEmpleados2= stmt.executeQuery(SELECT_SQL);
            while( resultadoEmpleados.next()){
                System.out.println("Mientras alla registro");

                System.out.println(resultadoEmpleados.getLong(1)+
                        " el nombre que trae de la bd de datos es "+
                        resultadoEmpleados.getString(2));
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


