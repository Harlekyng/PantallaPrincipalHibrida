package com.example.pantallaprincipalhibrida.clases

abstract class Empleado(val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val retencion = 13 // Porcentaje de retención para empleados a honorarios
        return sueldoBruto - (sueldoBruto * retencion / 100)
    }
}

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val retencion = 20 // Porcentaje de retención para empleados regulares por contrato
        return sueldoBruto - (sueldoBruto * retencion / 100)
    }
}
