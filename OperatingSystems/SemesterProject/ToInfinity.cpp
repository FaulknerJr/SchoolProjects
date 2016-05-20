// ToInfinity.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int andBeyond(int i);


int _tmain(int argc, _TCHAR* argv[])
{
	struct Piggie{
		int feeding = 3;
	};

	Piggie eat[50][100][50];
	for (int i = 0; i < 50; ++i){
			for (int k = 0; k < 50; ++k){
				eat[i][k].feeding += andBeyond(eat[i][j]);
			}
	}
	return 0;
}


