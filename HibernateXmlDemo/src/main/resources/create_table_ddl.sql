-- employee table
CREATE TABLE public.employee (
    emp_id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (emp_id)
);


-- employee_address table
CREATE TABLE "public"."employee_address" (
  "emp_addr_id" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "emp_id" INTEGER NOT NULL,
  "address" VARCHAR NULL,
  "city" VARCHAR NULL,
  "state" VARCHAR NULL,
  "zip" VARCHAR NOT NULL,
  CONSTRAINT "employee_address_pk" PRIMARY KEY ("emp_addr_id")
);

