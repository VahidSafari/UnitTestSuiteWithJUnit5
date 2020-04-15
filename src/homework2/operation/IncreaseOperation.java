/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework2.operation;

/**
 * @author EEB
 */
public class IncreaseOperation implements Operation {

    public int operate(int data) {
        return ++data;
    }
}