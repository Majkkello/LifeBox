package Logic;

/**
 * Created by esromic on 2017-06-26.
 */
public class SplinePath implements Path {
    /**
     * C++ code:
     * source.h
     * class spline {
         private:
     int n;
     double* x;
     double* y;
     double* u;
     double* h;
     double* v;
     double* z;

     public:
     spline(int n);
     void set_points( double x[], double y[]);
     double operator() (double z) const;
     };


     Nazwa pliku: source.cpp
     #include "source.h"

     spline::spline(int n) {
     this->n = n;
     u = new double[n];
     h = new double[n];
     v = new double[n];
     z = new double[n];
     }

     void spline::set_points(double *x, double *y) {
     this->x = x;
     this->y = y;

     double* b = new double[n];
     for(int i = 0; i < n - 1; ++i){
     h[i] = x[i + 1] - x[i];
     b[i] = (6 * y[i + 1] - 6 * y[i]) / h[i];
     }
     u[1] = 2*(h[0] + h[1]);
     v[1] = b[1] - b[0];
     for(int i = 2; i < n - 1; ++i){
     u[i] = 2*( h[i - 1] + h[i] ) - ( h[i - 1] * h[i - 1] ) / u[i - 1];
     v[i] = b[i] - b[i - 1] - (h[i - 1] * v[i - 1]) / u[i - 1];
     }
     z[n - 1] = 0;
     for(int i = n - 2; i > 0; --i){
     z[i] = (v[i] - (h[i] * z[i + 1])) / u[i];
     }
     z[0] = 0;
     }

     double spline::operator()(double z) const {
     double a, b, c;

     int i = n - 2;
     while((z - this->x[i]) < 0 && i > 0){ // && index > 0
     --i;
     }

     a = (this->z[i + 1] - this->z[i]) / (6 * this->h[i]);
     b = this->z[i] / 2;
     c = ( (y[i + 1] - y[i]) / h[i] ) - (h[i] / 6) * (this->z[i + 1] + 2 * this->z[i]);

     return y[i] + (z - x[i]) * ( c + (z - x[i]) * ( b + (z - x[i]) * a ) );
     }
     */
}
