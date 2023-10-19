package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.*;
import Week7.com.PatikaDev.Model.Operator;
import Week7.com.PatikaDev.Model.Path;
import Week7.com.PatikaDev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_userForm;
    private JTextField fld_userName;
    private JTextField fld_userUName;
    private JTextField fld_userPass;
    private JComboBox cmb_userType;
    private JButton btn_userAdd;
    private JTextField fld_userId;
    private JButton btn_userDelete;
    private JTextField fld_searchUserName;
    private JTextField fld_searchUserUName;
    private JComboBox cmb_searchUserType;
    private JButton btn_userSearch;
    private JPanel pnl_pathList;
    private JScrollPane scrl_pathList;
    private JTable tbl_pathList;
    private JPanel pnl_pathAdd;
    private JTextField fld_pathName;
    private JButton btn_pathAdd;
    private DefaultTableModel mdl_userList;
    private Object[] row_userList;
    private final Operator operator;
    private DefaultTableModel mdl_pathList;
    private Object[] row_pathList;
    private  JPopupMenu pathMenu;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Welcome " + operator.getName());

        //UserList
        mdl_userList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_userList = {"ID", "Name Surname", "Username", "Password", "Type"};
        mdl_userList.setColumnIdentifiers(col_userList);
        row_userList = new Object[col_userList.length];

        loadUserModel();

        tbl_userList.setModel(mdl_userList);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        tbl_userList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_userId=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString();
                    fld_userId.setText(select_userId);
                }catch (Exception exception){

                }
            }
        });
        tbl_userList.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int user_id = Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString());
                    String user_name = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),1).toString();
                    String user_uname = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),2).toString();
                    String user_pass = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),3).toString();
                    String user_type = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),4).toString();

                    if(User.update(user_id,user_name,user_uname,user_pass,user_type)){
                        Helper.showMassage("done");
                    }
                    loadUserModel();
                }
            }
        });

        //PathList
        pathMenu=new JPopupMenu();
        JMenuItem updateMenu= new JMenuItem("Update");
        JMenuItem deleteMenu= new JMenuItem("Delete");
        pathMenu.add(updateMenu);
        pathMenu.add(deleteMenu);

        updateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int select_id=Integer.parseInt(tbl_pathList.getValueAt(tbl_pathList.getSelectedRow(),0).toString());
                UpdatePathGUI updateGUI =new UpdatePathGUI(Path.getFetch(select_id));
                updateGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadPathModel();
                    }
                });
            }
        });

        mdl_pathList= new DefaultTableModel();
        Object[] col_pathList = {"ID", "Path Name"};
        mdl_pathList.setColumnIdentifiers(col_pathList);
        row_pathList=new Object[col_pathList.length];
        loadPathModel();

        tbl_pathList.setModel(mdl_pathList);
        tbl_pathList.setComponentPopupMenu(pathMenu);
        tbl_pathList.getTableHeader().setReorderingAllowed(false);
        tbl_pathList.getColumnModel().getColumn(0).setMaxWidth(100);

        tbl_pathList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow=tbl_pathList.rowAtPoint(point);
                tbl_pathList.setRowSelectionInterval(selectedRow,selectedRow);


            }
        });


        btn_userAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_userName) || Helper.isFieldEmpty(fld_userUName) || Helper.isFieldEmpty(fld_userPass)) {
                    Helper.showMassage("fill");
                } else {
                    String name = fld_userName.getText();
                    String uname = fld_userUName.getText();
                    String pass = fld_userPass.getText();
                    String type = cmb_userType.getSelectedItem().toString();
                    if (User.add(name, uname, pass, type)) {
                        Helper.showMassage("done");
                        loadUserModel();
                        fld_userName.setText(null);
                        fld_userUName.setText(null);
                        fld_userPass.setText(null);
                    }
                }
            }
        });
        btn_userDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_userId)) {
                    Helper.showMassage("fill");
                } else {
                    int userId = Integer.parseInt(fld_userId.getText());
                    if (User.delete(userId)) {
                        Helper.showMassage("done");
                        loadUserModel();
                    } else {
                        Helper.showMassage("error");
                    }
                }
            }
        });
        btn_userSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fld_searchUserName.getText();
                String uName= fld_searchUserUName.getText();
                String type= cmb_searchUserType.getSelectedItem().toString();
                String query=User.searchQuery(name,uName,type);
                ArrayList<User> searchUser = User.searchUserList(query);
                loadUserModel(searchUser);
            }
        });
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_pathAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_pathName)){
                    Helper.showMassage("fill");
                }else{
                    if(Path.add(fld_pathName.getText())){
                        Helper.showMassage("done");
                        loadPathModel();
                        fld_pathName.setText(null);
                    }else{
                        Helper.showMassage("error");
                    }
                }
            }
        });
    }

    private void loadPathModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_pathList.getModel();
        clearModel.setRowCount(0);
        int i ;
        for(Path obj : Path.getList()){
            i=0;
            row_pathList[i++]=obj.getId();
            row_pathList[i++]=obj.getName();
            mdl_pathList.addRow(row_pathList);
        }
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : User.getList()) {
            i=0;
            row_userList[i++] = obj.getId();
            row_userList[i++] = obj.getName();
            row_userList[i++] = obj.getuName();
            row_userList[i++] = obj.getPass();
            row_userList[i++] = obj.getType();
            mdl_userList.addRow(row_userList);
        }
    }
    public void loadUserModel(ArrayList<User> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        for (User obj : list) {
            int i = 0;
            row_userList[i++] = obj.getId();
            row_userList[i++] = obj.getName();
            row_userList[i++] = obj.getuName();
            row_userList[i++] = obj.getPass();
            row_userList[i++] = obj.getType();
            mdl_userList.addRow(row_userList);
        }
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator op = new Operator();
        op.setId(1);
        op.setName("Batuhan Özüdoğru");
        op.setuName("Batuhan");
        op.setPass("123");
        op.setType("operator");
        DBConnector.getInstance();
        OperatorGUI operatorGUI = new OperatorGUI(op);
    }


}
