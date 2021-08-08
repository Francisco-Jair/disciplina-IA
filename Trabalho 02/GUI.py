import tkinter
from tkinter import *
from perceptron1 import Perceptron, entradas, saidasEsperadas, pesosEntradas

modeloPerceptron = Perceptron(entradas, saidasEsperadas, pesosEntradas, 0.8)
modeloPerceptron.treino()


# 0,2
# 0,3


def neynar():
    newWindow = tkinter.Toplevel(window)
    imagem = tkinter.PhotoImage(file='neymar.png')
    w = tkinter.Label(newWindow, image=imagem)
    w.imagem = imagem
    w.pack()

def gabriel():
    newWindow = tkinter.Toplevel(window)
    imagem = tkinter.PhotoImage(file='gabriel.png')
    w = tkinter.Label(newWindow, image=imagem)
    w.imagem = imagem
    w.pack()

def federer():
    newWindow = tkinter.Toplevel(window)
    imagem = tkinter.PhotoImage(file='Federer.png')
    w = tkinter.Label(newWindow, image=imagem)
    w.imagem = imagem
    w.pack()

def nadal():
    newWindow = tkinter.Toplevel(window)
    imagem = tkinter.PhotoImage(file='nadal.png')
    w = tkinter.Label(newWindow, image=imagem)
    w.imagem = imagem
    w.pack()


def mostrarNome(i, j):
    if modeloPerceptron.search(int(i), int(j)) == 1:
        if int(i) == 0 and int(j) == 0:
            neynar()
        elif int(i) == 0 and int(j) == 1:
            gabriel()
        elif int(i) == 1 and int(j) == 0:
            federer()
        elif int(i) == 1 and int(j) == 1:
            nadal()
    else:
        pass

    
    
    

window = tkinter.Tk()
window.title("Trabalho")
# window.minsize("720", "480")
window.minsize("300", "100")

label = Label(window, text="Entrada 1: ")
label.pack(side=LEFT)
labelInput = StringVar()
labelInput = Entry(window, textvariable=labelInput)
labelInput.pack(side=LEFT)

label2 = Label(window, text="Entrada 2: ")
label2.pack(side=LEFT)
labelInput2 = StringVar()
labelInput2 = Entry(window, textvariable=labelInput2)
labelInput2.pack(side=LEFT)


button = Button(window, text="Resultado", command=lambda: mostrarNome(labelInput.get(), labelInput2.get()))
button.pack(side=LEFT)


window.mainloop()