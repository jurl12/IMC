package imc;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Pestaña extends JFrame implements ActionListener{

    JPanel Panel;
    JLabel titulo,nombre,altura,peso,resul;
    JTextField c1,c2,c3;
    JButton boton1,boton2;

    Procesos miproceso;
    public Pestaña() {
        miproceso = new Procesos();
        setTitle("Calculadora de IMC");
        setSize(600,450);
        setLocationRelativeTo(null);
        IniciarComponentes();
    }

    public void IniciarComponentes() {
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(Color.gray);

        titulo = new JLabel();
        titulo.setText("IMC");
        titulo.setBounds(160, 30, 600, 60);
        titulo.setFont(new Font("Arial",Font.ITALIC,30));
        getContentPane().add(titulo);
        getContentPane().add(Panel);
        
                c1 = new JTextField();
                Panel.add(c1);
                c1.setBounds(27, 154, 160, 30);
                
                        nombre = new JLabel();
                        Panel.add(nombre);
                        nombre.setText("Nombre");
                        nombre.setBounds(92, 11, 50, 200);
                        
                                altura = new JLabel();
                                Panel.add(altura);
                                altura.setText("Estatura");
                                altura.setBounds(275, 96, 200, 30);
                                
                                        c2 = new JTextField();
                                        Panel.add(c2);
                                        c2.setBounds(223, 154, 160, 30);
                                        
                                                c3 = new JTextField();
                                                Panel.add(c3);
                                                c3.setBounds(414, 154, 160, 30);
                                                
                                                        peso= new JLabel();
                                                        Panel.add(peso);
                                                        peso.setText("Peso");
                                                        peso.setBounds(447, 96, 200, 30);
                                                        
                                                                boton1 = new JButton();
                                                                Panel.add(boton1);
                                                                boton1.setText("Calcular");
                                                                boton1.setBounds(110, 222, 150, 30);
                                                                
                                                                        boton2 = new JButton();
                                                                        Panel.add(boton2);
                                                                        boton2.setText("Limpiar");
                                                                        boton2.setBounds(296, 222, 150, 30);
                                                                        
                                                                                resul= new JLabel();
                                                                                Panel.add(resul);
                                                                                resul.setText("IMC:");
                                                                                resul.setBounds(47,284 , 600, 30);
                                                                        boton2.addActionListener(this);
                                                                boton1.addActionListener(this);
    }

    public void calcular() {
        String nombre=c1.getText();
        double altura=Double.parseDouble(c2.getText());
        double peso=Double.parseDouble(c3.getText());

        double imc = miproceso.calcularIMC(altura, peso);
        String resultadoIMC = miproceso.evaluarIMC(imc);

        if(imc < 18.5) {
            resul.setText("Hola "+nombre+ " IMC:"+imc+ " Usted esta en bajo peso");
            resul.setForeground(Color.red);
        } else if (imc >= 18.5 && imc < 24.9) {
            resul.setText("Hola "+nombre+ " IMC: "+imc+ " Usted esta en peso saludable");
            resul.setForeground(Color.red);
        } else if (imc >= 25 && imc < 29.9) {
            resul.setText("Hola "+nombre+ " IMC: "+imc+ " Usted esta en sobre peso");
            resul.setForeground(Color.red);
        } else {
            resul.setText("Hola "+nombre+ " IMC: "+imc+ " Usted esta obeso");
            resul.setForeground(Color.red);
        }

        resul.setBackground(Color.black);
    }



    public void Limpiar() {
        c1.setText("");
        c2.setText("");
        c3.setText("");
        resul.setText("IMC:");
        resul.setBackground(Color.black);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("calculado");
            calcular();
        }else if(e.getSource()==boton2) {
            
            Limpiar();
        }

    }



}