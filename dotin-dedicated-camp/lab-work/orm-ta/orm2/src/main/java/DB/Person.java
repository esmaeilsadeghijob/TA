package DB;

import annot.Column;
import annot.Id;
import annot.Table;

@Table(name = "Person")
public class Person {
    @Id(name="id")
    public int id;
    @Column(name="id",dataType = "varchar",size = 50)
    public String name;

}
