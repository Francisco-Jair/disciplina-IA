"""
               | Classes
Neymar  (0, 0) | Futebol(0)
Gabriel (0, 1) | Futebol(0)
Federer (1, 0) | Tenis(1)
Nadal   (1, 1) | Tenis(1)

Função de ativação (Step)

 h(x) > 0 -> 1
 h(x) <= 0 -> 0
 ou 

A de baixo

 h(x)| x < 0 -> 0
 h(x)| x >= 0 -> 1


Erro = (Saida - predição)

Calculo do pesos(Ajuste)
learning_rate -> O ajuste que vc quer fazer para melhorar (Procurar formula)
novo_peso = pesoAtual + learning_rate * erro * entrada


"""
import numpy as np


entradas = [
    [1, 1],
    [0, 1],
    [1, 0],
    [0, 0]
]
saidasEsperadas = [1, 0, 1, 0]

"""
entradas = [
    [0, 0],
    [0, 1],
    [1, 0],
    [1, 1]
]
saidasEsperadas = [0, 0, 1, 1]
"""


class Perceptron():
    
    def __init__(self, entradas, saidasEsperadas, pesosEntradas, bias=1, learning_rate=1):
        self.entradas = entradas
        self.saidasEsperadas = saidasEsperadas
        # self.pesosW = np.zeros(len(entradas[0]))
        self.pesosW = np.array(pesosEntradas, dtype=float)
        self.epoca = 0
        self.learning_rate = learning_rate
        self.bias = bias
        self.pesoBias = 0
        

    def funcaoDeAtivacao(self, valor):
        if valor > 0:
            return 1
        else:
            return 0
    
    def ajustePeco(self, erro, j):
        
        #Ajusta Peso sinaptico do bias
        self.pesoBias = self.pesoBias + (self.learning_rate * erro * self.bias)

        for i in range(len(self.pesosW)):
            self.pesosW[i] = self.pesosW[i] + (self.learning_rate * erro  * self.entradas[j][i])
    
    def treino(self):
        # print(self.pesosW)
        acertos = 0
        
        while True:
            flagCont = True

            for i in range(0, len(self.entradas)):

                a = self.entradas[i][0]
                b = self.entradas[i][1]

                somatoria = (a * self.pesosW[0]) + (b * self.pesosW[1]) + (self.bias * self.pesoBias)
    
                valorFuncao = self.funcaoDeAtivacao(somatoria)
                
                # Quer dizer que errou
                if valorFuncao != self.saidasEsperadas[i]:
                    erro = self.saidasEsperadas[i] - valorFuncao
                    self.ajustePeco(erro, i)
                    
                    flagCont = False
                    acertos = 0
                
                if flagCont:
                    #Acertou
                    acertos += 1

            print("EPOCA: ", self.epoca)
            print("PESO 1: ", self.pesosW[0])
            print("PESO 2: ", self.pesosW[1])
            self.epoca += 1

            if acertos == 4:
                break
            elif flagCont == False:
                acertos = 0

    def modelo(self, a, b):
        somatoria = (a * self.pesosW[0]) + (b * self.pesosW[1])
        valorFuncao = self.funcaoDeAtivacao(somatoria)
        return valorFuncao
    
    def search(self, a, b):
        valorMod = self.modelo(a, b)
        
        if a == 0 and b == 0:
            if valorMod == 0:
                return 1
        elif a == 0 and b == 1:
            if valorMod == 0:
                return 1
        elif a == 1 and b == 0:
            if valorMod == 1:
                return 1
        elif a == 1 and b == 1:
            if valorMod == 1:
                return 1

            
pesosEntradas = np.array([0.9, 0.7], float)
modeloPerceptron = Perceptron(entradas, saidasEsperadas, pesosEntradas, 0.8)
# modeloPerceptron.treino()


# print(" ----------  Teste ----------")
# print("1  1  | ", modeloPerceptron.modelo(1, 1))
# print("0  1  | ", modeloPerceptron.modelo(0, 1))
# print("1  0  | ", modeloPerceptron.modelo(1, 0))
# print("0  0  | ", modeloPerceptron.modelo(0, 0))
# print("----------- FIM -------------")

# print(modeloPerceptron.epoca)
# print(modeloPerceptron.pesosW)