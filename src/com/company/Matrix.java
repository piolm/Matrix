package com.company;

import java.util.Arrays;
import java.util.Scanner;
public class Matrix{

    private double[][] matrix;
    private int rows; private int columns;

    public Matrix(int rows, int columns) {
        matrix = new double[rows][columns];
        double[] temp = new double[rows];
        Arrays.fill(temp, 0);
        Arrays.fill(matrix, temp);
    }
    public Matrix()
    {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("rows: ");
        rows = in.nextInt();
        System.out.print("columns: ");
        columns = in.nextInt();
        matrix = new double[rows][columns];
        System.out.println("enter elements: ");
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print("element: [" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = in.nextDouble();
            }
        }
    }

    public Matrix(Matrix c){
        this.matrix = c.matrix;
    }

    private int getRows(){
        return rows;
    }

    private int getColumns(){
        return columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    private double getElement(int rows, int columns){
        return matrix[rows][columns];
    }

    private void assignElement(double value, int i, int j){
        matrix[i][j] = value;
    }


    public static Matrix Add(Matrix firstMatrix, Matrix secondMatrix)
    {
        Matrix addUpResult = new Matrix(firstMatrix.getRows(), firstMatrix.getColumns());
        double value;
        System.out.println();
        System.out.println("result of 2 matrices add-up: ");

        if(firstMatrix.getRows() == secondMatrix.getRows() && firstMatrix.getColumns() == secondMatrix.getColumns())
        {
            for(int i = 0; i < firstMatrix.getRows(); i++)
            {
                for(int j = 0; j < secondMatrix.getColumns(); j++)
                {
                    value = firstMatrix.getElement(i,j) + secondMatrix.getElement(i,j);
                    addUpResult.assignElement(value,i,j);
                    System.out.print("[" + addUpResult.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return addUpResult;
        }
        else{System.out.println("rows or columns are not equal"); return addUpResult;}
    }


    public static Matrix Subtract(Matrix matrix1, Matrix matrix2)
    {
        Matrix subResult = new Matrix(matrix1.getRows(), matrix1.getColumns());
        double value;
        System.out.println();
        System.out.println("result: ");

        if(matrix1.getRows() == matrix2.getRows() && matrix1.getColumns() == matrix2.getColumns())
        {
            for(int i = 0; i < matrix1.getRows(); i++)
            {
                for(int j = 0; j < matrix2.getColumns(); j++)
                {
                    value = matrix1.getElement(i,j) - matrix2.getElement(i,j);
                    subResult.assignElement(value,i,j);
                    System.out.print("[" + subResult.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return subResult;
        }
        else{System.out.println("rows or columns are not equal"); return subResult;}
    }

    public static Matrix Multiply(Matrix matrix1, Matrix matrix2)
    {
        Matrix multiplyResult = new Matrix(matrix1.getRows(), matrix2.getColumns());
        double value;
        System.out.println();
        System.out.println("result: ");

        if(matrix1.getColumns() == matrix2.getRows())
        {
            for(int i = 0; i < matrix1.getRows(); i++)
            {
                for(int j = 0; j < matrix2.getColumns(); j++)
                {
                    double sum = 0;
                    for(int k = 0; k < matrix1.getRows(); k++)
                    {
                        sum += matrix1.getElement(i,k) * matrix2.getElement(k,j);
                    }
                    value = sum;
                    multiplyResult.assignElement(value,i,j);
                    System.out.print("[" + multiplyResult.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return multiplyResult;
        }
        else{System.out.println("rows and columns not equal"); return multiplyResult;}
    }


    public Matrix add(Matrix matrix1)
    {
        Matrix result = new Matrix(rows, columns);
        double value;
        System.out.println();
        System.out.println("result: ");

        if(rows == matrix1.getRows() && columns == matrix1.getColumns())
        {
            for(int i = 0; i < matrix1.getRows(); i++)
            {
                for(int j = 0; j < matrix1.getColumns(); j++)
                {
                    value = matrix[i][j] + matrix1.getElement(i,j);
                    result.assignElement(value,i,j);
                    System.out.print("[" + result.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return result;
        }
        else{System.out.println("rows or columns are not equal"); return result;}
    }


    public Matrix subtract(Matrix matrix1)
    {
        Matrix resultMatrix = new Matrix(rows, columns);
        double value;
        System.out.println();
        System.out.println("result: ");

        if(rows == matrix1.getRows() && columns == matrix1.getColumns())
        {
            for(int i = 0; i < matrix1.getRows(); i++)
            {
                for(int j = 0; j < matrix1.getColumns(); j++)
                {
                    value = matrix[i][j] - matrix1.getElement(i,j);
                    resultMatrix.assignElement(value,i,j);
                    System.out.print("[" + resultMatrix.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return resultMatrix;
        }
        else{System.out.println("rows or columns are not equal"); return resultMatrix;}
    }

    public Matrix multiply(Matrix matrix1)
    {
        Matrix resultMatrix = new Matrix(rows, matrix1.getColumns());
        double value;
        System.out.println();
        System.out.println("result: ");

        if(columns == matrix1.getRows())
        {
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < matrix1.getColumns(); j++)
                {
                    double sum = 0;
                    for(int k = 0; k < rows; k++)
                    {
                        sum += matrix[i][k] * matrix1.getElement(k,j);
                    }
                    value = sum;
                    resultMatrix.assignElement(value,i,j);
                    System.out.print("[" + resultMatrix.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return resultMatrix;
        }
        else{System.out.println("rows and columns not equal"); return resultMatrix;}
    }

    public String toString()
    {
        String es = "";

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                es += "[";
                es += matrix[i][j];
                es += "]";
            }
            es += '\n';
        }
        System.out.println();
        return es;
    }

}