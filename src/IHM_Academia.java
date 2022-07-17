import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IHM_Academia extends JFrame {

    private JPanel mainPanel;
    private JComboBox cbTipoPessoa;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtSalario;
    private JTextField txtCpf;
    private JTextField txtMensalidade;
    private JButton btnCadastrar;
    private JButton btnDeletar;
    private JButton btnEditar;
    private JTable tbPessoas;



    public IHM_Academia(String title) {
        super (title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        tbPessoas.setModel(new DefaultTableModel(
                    null,
                    new String [] {"NOME", "CPF", "TELEFONE", "SALÁRIO", "MENSALIDADE"}
            ){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        });



        cbTipoPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbTipoPessoa.getSelectedItem().equals("")){
                    txtNome.setEditable(false);
                    txtNome.setEnabled(false);
                    txtCpf.setEditable(false);
                    txtCpf.setEnabled(false);
                    txtTelefone.setEditable(false);
                    txtTelefone.setEnabled(false);
                    txtSalario.setEditable(false);
                    txtSalario.setEnabled(false);
                    txtMensalidade.setEditable(false);
                    txtMensalidade.setEnabled(false);

                } else if (cbTipoPessoa.getSelectedItem().equals("Funcionario")) {
                    txtNome.setEditable(true);
                    txtNome.setEnabled(true);
                    txtCpf.setEditable(true);
                    txtCpf.setEnabled(true);
                    txtTelefone.setEditable(true);
                    txtTelefone.setEnabled(true);
                    txtSalario.setEditable(true);
                    txtSalario.setEnabled(true);
                    txtSalario.setText("");
                    txtMensalidade.setEditable(false);
                    txtMensalidade.setEnabled(false);
                    txtMensalidade.setText("N/A");


                } else if (cbTipoPessoa.getSelectedItem().equals("Aluno")) {
                    txtNome.setEditable(true);
                    txtNome.setEnabled(true);
                    txtCpf.setEditable(true);
                    txtCpf.setEnabled(true);
                    txtTelefone.setEditable(true);
                    txtTelefone.setEnabled(true);
                    txtSalario.setEditable(false);
                    txtSalario.setEnabled(false);
                    txtSalario.setText("N/A");
                    txtMensalidade.setEditable(true);
                    txtMensalidade.setEnabled(true);
                    txtMensalidade.setText("");


                } else if (cbTipoPessoa.getSelectedItem().equals("Recepcionista")) {
                        txtNome.setEditable(true);
                        txtNome.setEnabled(true);
                        txtCpf.setEditable(true);
                        txtCpf.setEnabled(true);
                        txtTelefone.setEditable(true);
                        txtTelefone.setEnabled(true);
                        txtSalario.setEditable(true);
                        txtSalario.setEnabled(true);
                        txtSalario.setText("");
                        txtMensalidade.setEditable(false);
                        txtMensalidade.setEnabled(false);
                        txtMensalidade.setText("N/A");
                }
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtNome.getText().equals("") || txtCpf.getText().equals("") || txtTelefone.getText().equals("")
                        || txtSalario.getText().equals("") || txtMensalidade.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
                } else{
                    DefaultTableModel dtm = (DefaultTableModel) tbPessoas.getModel();
                Object[] dados = {txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), txtSalario.getText(), txtMensalidade.getText()};
                dtm.addRow(dados);

                txtNome.setText("");
                txtCpf.setText("");
                txtTelefone.setText("");
                if (cbTipoPessoa.getSelectedItem().equals("Funcionario")) {
                    txtSalario.setText("");
                    txtMensalidade.setText("N/A");
                } else if (cbTipoPessoa.getSelectedItem().equals("Aluno")) {
                    txtSalario.setText("N/A");
                    txtMensalidade.setText("");

                } else {
                    txtSalario.setText("");
                    txtMensalidade.setText("");
                }
            }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tbPessoas.getSelectedRow() != -1) {
                    DefaultTableModel dtm = (DefaultTableModel) tbPessoas.getModel();
                    dtm.removeRow(tbPessoas.getSelectedRow());
                }else {
                    JOptionPane.showMessageDialog(null, "Selecione o cadastro que deseja excluir");
                }

            }
        });
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tbPessoas.getSelectedRow() != -1){
                    tbPessoas.setValueAt(txtNome.getText(), tbPessoas.getSelectedRow(), 0);
                    tbPessoas.setValueAt(txtCpf.getText(), tbPessoas.getSelectedRow(), 1);
                    tbPessoas.setValueAt(txtTelefone.getText(), tbPessoas.getSelectedRow(), 2);
                    tbPessoas.setValueAt(txtSalario.getText(), tbPessoas.getSelectedRow(), 3);
                    tbPessoas.setValueAt(txtMensalidade.getText(), tbPessoas.getSelectedRow(), 4);
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione o cadastro que deseja editar");
                }
            }
        });
        tbPessoas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    txtNome.setText(tbPessoas.getValueAt(tbPessoas.getSelectedRow(), 0).toString());
                    txtCpf.setText(tbPessoas.getValueAt(tbPessoas.getSelectedRow(), 1).toString());
                    txtTelefone.setText(tbPessoas.getValueAt(tbPessoas.getSelectedRow(), 2).toString());
                    if(txtSalario.getText().equals("N/A")){
                        txtSalario.setText("N/A");
                    }else{
                        txtSalario.setText(tbPessoas.getValueAt(tbPessoas.getSelectedRow(), 3).toString());

                    }
                    if(txtMensalidade.getText().equals("N/A")){
                        txtMensalidade.setText("N/A");
                    }else{
                        txtMensalidade.setText(tbPessoas.getValueAt(tbPessoas.getSelectedRow(), 4).toString());

                    }

               // }
            }
        });
    }
}
